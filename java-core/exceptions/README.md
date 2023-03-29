### 1 case. What will be printed:

```java
public class Test {

    public static void main(String[] args) {
        try {
            try {
                if (true) {
                    throw new RuntimeException();
                }
            } catch (RuntimeException e) {
                System.err.print(" 1");
            } catch (Exception e) {
                System.err.print(" 2");
            } finally {
                System.err.print(" 3");
            }
        } catch (RuntimeException e) {
            System.err.print(" 4");
        } catch (Exception e) {
            System.err.print(" 5");
        } finally {
            System.err.print(" 6");
        }
    }
}
```

### 2 case. Analyze the code and refactor it (do not use try-with-resources).

```java
public class Test {
    public static void readFile(File file) {

        RandomAccessFile input = null;
        String line = null;
        try {
            input = new RandomAccessFile(file, "r");
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            return;
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }
}
```

### 3 case. Create suppressed exception example.

### 4 case. Create example custom checked and unchecked exceptions.

### 5 case. Create example for exception Handling with Method overriding

### 6 case. Throw and catch exception in constructor and observe if object will be created.
