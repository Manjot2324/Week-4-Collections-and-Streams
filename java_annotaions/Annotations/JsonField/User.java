
import java.lang.reflect.Field;
import java.util.HashMap;

public class User {
  @JsonField(name = "user_name")
  private String name;

  @JsonField(name = "user_age")
  private int age;

  @JsonField(name = "user_email")
  private String email;

  public User(String name, int age, String email) {
    this.name = name;
    this.age = age;
    this.email = email;
  }

  public String toJSON() {
    HashMap<String, String> jsonMap = new HashMap<>(); // for serialization in the map
    Field[] fields = this.getClass().getDeclaredFields(); // will get all the instance fields of the User class

    for (Field field : fields) {
      if (field.isAnnotationPresent(JsonField.class)) {
        try {
          JsonField annotation = field.getAnnotation(JsonField.class);
          field.setAccessible(true);
          jsonMap.put(annotation.name(), field.get(this).toString());
        } catch (IllegalAccessException ex) {
        }
      }
    }

    return jsonMap.toString().replace("=", " : ") ;
  }

  public static void main(String[] args) {
    User user = new User("Alice", 10, "aliceBorderland@gmail");
    System.out.println(user.toJSON());
  }

}
