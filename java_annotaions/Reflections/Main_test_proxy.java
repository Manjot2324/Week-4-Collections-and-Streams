import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// Step 1: Define an Interface
interface Greeting {
    void sayHello(String name);
}

// Step 2: Implement the Interface
class GreetingImpl implements Greeting {
    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }
}

// Step 3: Create a Logging Proxy Handler
class LoggingProxyHandler implements InvocationHandler {
    private final Object target;

    public LoggingProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("[LOG] Calling method: " + method.getName());
        return method.invoke(target, args);
    }
}

// Step 4: Create a Proxy Factory
class ProxyFactory {
    @SuppressWarnings("unchecked")
    public static <T> T createProxy(T target, Class<T> interfaceType) {
        return (T) Proxy.newProxyInstance(
            interfaceType.getClassLoader(),
            new Class<?>[]{interfaceType},
            new LoggingProxyHandler(target)
        );
    }
}

// Step 5: Test the Proxy
public class Main_test_proxy {
    public static void main(String[] args) {
        Greeting greeting = ProxyFactory.createProxy(new GreetingImpl(), Greeting.class);
        greeting.sayHello("Alice");
    }
}
