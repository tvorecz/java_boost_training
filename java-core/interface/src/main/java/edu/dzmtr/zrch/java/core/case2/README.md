### Create 2 interfaces
with the same names for default, the same names for static and the same names for private methods and try to use it.

### Explanation
#### Default/Public methods
> The proposed exercise is mostly related to resolving method conflicts in children that implement several interfaces with the same method names and signatures.
> The issue is related to both public and default methods. To resolve it we should:
> - override public/default method;
> - use custom logic inside or just call a parent interface default implementation, using following syntax:
> ```java 
>  InterfaceName.super.method()
> ```

#### Static methods
> Public static methods of interfaces in case of coincidence of the method names and signatures can be accessed, as usual, via Type Name in both descendants and another classes inside inheritance hierarchy

#### Private method
> Private instance methods of interfaces in case of coincidence of the method names and signatures cannot be accessed in both descendants and another classes inside inheritance hierarchy. They can be used only inside related interface. For example, in default or other private instance methods.