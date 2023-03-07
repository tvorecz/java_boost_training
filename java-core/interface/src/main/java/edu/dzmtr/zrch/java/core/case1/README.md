### Will the code be compiled and running?
```java
public interface A{
  void doSome();
}

public class B implements A{
  @Override
  void doSome() {
	//....
  }
}
```

### Explanation:

>Class will not be compiled because of two reason:
> - Annotation @Override is not allowed to use with implementation of interface methods. **It should be removed**.
> - We can not narrow the privacy of the implemented method in child objects. **Method should be made public**. 


### Fixed example:
```java
public class B implements A{

    public void doSome() {
        
    }
}
```