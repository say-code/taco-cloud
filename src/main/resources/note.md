# 随记
## Spring Security
以下代码可以在程序的任何地方使用以获得user
```java
Authentication auth = SecurityContextHolder.getContext().getAuthentication();
Users users = (Users) auth.getPrincipal(); 
```