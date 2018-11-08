# there is an issue here 

			org.springframework.beans.factory.BeanNotOfRequiredTypeException: Bean named 'transactionManager' is expected to be of type 'org.springframework.transaction.PlatformTransactionManager' but was actually of type 'org.bytesoft.bytetcc.TransactionManagerImpl'
				at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:389) ~[spring-beans-5.0.10.RELEASE.jar:5.0.10.RELEASE]
				at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:204) ~[spring-beans-5.0.10.RELEASE.jar:5.0.10.RELEASE]
				at org.springframework.beans.factory.annotation.BeanFactoryAnnotationUtils.qualifiedBeanOfType(BeanFactoryAnnotationUtils.java:106) ~[spring-beans-5.0.10.RELEASE.jar:5.0.10.RELEASE]
				at org.springframework.beans.factory.annotation.BeanFactoryAnnotationUtils.qualifiedBeanOfType(BeanFactoryAnnotationUtils.java:68) ~[spring-beans-5.0.10.RELEASE.jar:5.0.10.RELEASE]
				at org.springframework.transaction.interceptor.TransactionAspectSupport.determineQualifiedTransactionManager(TransactionAspectSupport.java:406) ~[spring-tx-5.0.10.RELEASE.jar:5.0.10.RELEASE]
				at org.springframework.transaction.interceptor.TransactionAspectSupport.determineTransactionManager(TransactionAspectSupport.java:384) ~[spring-tx-5.0.10.RELEASE.jar:5.0.10.RELEASE]
				at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:284) ~[spring-tx-5.0.10.RELEASE.jar:5.0.10.RELEASE]
				at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:98) ~[spring-tx-5.0.10.RELEASE.jar:5.0.10.RELEASE]
				at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:185) ~[spring-aop-5.0.10.RELEASE.jar:5.0.10.RELEASE]
				at org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint.proceed(MethodInvocationProceedingJoinPoint.java:88) ~[spring-aop-5.0.10.RELEASE.jar:5.0.10.RELEASE]
				at org.bytesoft.bytetcc.supports.spring.CompensableMethodInterceptor$AspectJoinpoint.proceed(CompensableMethodInterceptor.java:295) ~[bytetcc-supports-0.5.0-ALPHA3.jar:na]
				at org.bytesoft.bytetcc.supports.spring.CompensableMethodInterceptor.execute(CompensableMethodInterceptor.java:260) ~[bytetcc-supports-0.5.0-ALPHA3.jar:na]
				at org.bytesoft.bytetcc.supports.spring.CompensableMethodInterceptor.invoke(CompensableMethodInterceptor.java:126) ~[bytetcc-supports-0.5.0-ALPHA3.jar:na]
				at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:1.8.0_171]
				at sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source) ~[na:1.8.0_171]
				at sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source) ~[na:1.8.0_171]
				
## how to reproduce

### 1, run mongodb

	spring.data.mongodb.uri: mongodb://127.0.0.1:27017/bytetcc
	
### 2, run zookeeper

	127.0.0.1:2181

### 3, run mysql & add a new database named 'account-db'

		spring.datasource.url: jdbc:mysql://127.0.0.1:3306/account-db
		
		
### 4, run spring boot project

### 5, POST localhost:8090/tcc/accounts/1/pay/?orderId=1

### 6, you will see the exception


