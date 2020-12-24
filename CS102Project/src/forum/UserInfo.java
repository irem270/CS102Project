package forum;

public class UserInfo {
static String name;
static String email;
static int password;
public static String getName() {
	return name;
}
public static void setName(String name) {
	UserInfo.name = name;
}
public static String getEmail() {
	return email;
}
public static void setEmail(String email) {
	UserInfo.email = email;
}
public static int getPassword() {
	return password;
}
public static void setPassword(int password) {
	UserInfo.password = password;
}
}
