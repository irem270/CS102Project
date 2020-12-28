package company;

import bsh.EvalError;
import bsh.Interpreter;

import javax.tools.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Compiler {

    public List<String> compile(String code) throws IOException {

        File myObj = new File("Exercise.java");
        try {
            myObj.createNewFile();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        FileWriter myWriter = new FileWriter(myObj);

        myWriter.write(code);
        myWriter.close();

        // set up compiler
        final JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        final DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
        final List<String> errors = new ArrayList<>();
        try (final StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null)) {
            final Iterable<? extends JavaFileObject> compilationUnits = fileManager
                    .getJavaFileObjectsFromFiles(Arrays.asList(myObj));

            // compile generated source
            // (switch off annotation processing: no need to create Log4j2Plugins.dat)
            final List<String> options = Arrays.asList("-proc:none");
            compiler.getTask(null, fileManager, diagnostics, options, null, compilationUnits).call();

            // check we don't have any compilation errors
            for (final Diagnostic<? extends JavaFileObject> diagnostic : diagnostics.getDiagnostics()) {
                if (diagnostic.getKind() == Diagnostic.Kind.ERROR) {
                    errors.add(String.format("Compile error: %s%n" + " on line : " + diagnostic.getLineNumber(),
                            diagnostic.getMessage(Locale.getDefault())));
                }

            }
        }

        return errors;
    }

    public Object interpreter(String code) throws EvalError {
        Interpreter interpreter = new Interpreter();
        return interpreter.eval(code);

    }
}