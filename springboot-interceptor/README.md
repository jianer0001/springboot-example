####一、自定义拦截器的步骤
1.自定义类实现HandleInterceptor
2.添加@Configuration注解
3.重写里面的全部三个方法


####二.自定义拦截器的执行顺序
1.在WebMvcConfig中添加拦截器的的顺序就是自定义拦截器的执行顺序