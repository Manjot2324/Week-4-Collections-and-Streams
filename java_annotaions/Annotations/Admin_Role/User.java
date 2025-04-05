import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class User {
  private final String type;

  User(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }

  @RoleAllowed(user = "ADMIN")
  public void restrictedMethod() {
    System.out.println("Restricted method executed!");
  }

  void executeRestrictedMethod() {
    try {
      Method method = this.getClass().getDeclaredMethod("restrictedMethod");

      if (method.isAnnotationPresent(RoleAllowed.class)) {
        RoleAllowed annotation = method.getAnnotation(RoleAllowed.class);

        if (!this.type.equals(annotation.user())) {
          System.out.println("Access Denied!");
        }else{
          method.invoke(this);
        } 
      }
    } catch (IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
      System.out.println("Exception handled");
    }
  }

  public static void main(String[] args) {
    User user1 = new User("Student");
    User user2 = new User("ADMIN");

    System.out.println("user 1(student) trying to access the admin method: ");
    user1.executeRestrictedMethod();
    System.out.println("\nuser 2(admin) trying to access the admin method: ");
    user2.executeRestrictedMethod();
  }
}
