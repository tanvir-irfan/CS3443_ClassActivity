package edu.utsa.nestedClass;

public class HelloWorldAnonymousClasses {

	interface HelloWorld {
		public void greet();

		public void greetSomeone(String someone);
	}

	public void sayHello() {
		// HelloWorld englishGreeting = new EnglishGreeting();

		// Example of local class
		class EnglishGreeting implements HelloWorld {
			String name = "world";

			public void greet() {
				greetSomeone("world");
			}

			public void greetSomeone(String someone) {
				name = someone;
				System.out.println("Hello " + name);
			}
		}

		HelloWorld englishGreeting = new EnglishGreeting();

		
		// Example of local class
		HelloWorld frenchGreeting = new HelloWorld() {
			String name = "tout le monde";

			public void greet() {
				greetSomeone("tout le monde");
			}

			public void greetSomeone(String someone) {
				name = someone;
				System.out.println("Salut " + name);
			}
		};

		englishGreeting.greet();
		frenchGreeting.greetSomeone("Fred");
	}

	public static void main(String... args) {
		HelloWorldAnonymousClasses myApp = new HelloWorldAnonymousClasses();
		myApp.sayHello();
	}
}