### Create 2 interfaces
with the same names for default, the same names for static and the same names for private methods and try to use it.

### Explanation
#### Default/Public methods
> To call interface default methods inside implementation class, we should use following syntax:
> ```java 
>  InterfaceName.super.method()
> ```

#### Static methods
> Public static methods of interfaces can be accessed, as usual, via Type Name in both descendants and another classes outside inheritance hierarchy

#### Private method
> Private instance methods of interfaces cannot be accessed in both descendants and another classes inside inheritance hierarchy. They can be used only inside related interface. For example, in default or other private instance methods.