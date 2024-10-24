# CodeStyle

The project is written based on the code style provided by Java mainstream official standard.

Source: [https://v2.vuejs.org/v2/style-guide/?redirect=true](https://blog.csdn.net/qq_34869143/article/details/94554253)

## 1. Identifier Naming Convention

### 1.1 Overview

Identifier naming aims to be uniform, meaningful, and concise.

#### 1.1.1 Uniformity

Uniformity means using the same representation for the same concept in the program. For example, for a supplier, you can use either "supplier" or "provider," but you must choose one to use, at least consistently within a Java project. Uniformity is crucial because different representations for the same concept can confuse and make the code difficult to understand. Even if the names are not perfect, as long as they are consistent, reading will not be too challenging since the reader only needs to understand it once.

#### 1.1.2 Meaningfulness

Meaningfulness refers to identifiers accurately expressing the meaning they represent. For example: newSupplier, OrderPaymentGatewayService are good naming conventions, while supplier1, service2, idtts are not. Accuracy encompasses correctness and richness. Naming a variable representing a supplier as "order" is clearly incorrect. Similarly, supplier1 is far less meaningful than targetSupplier.

#### 1.1.3 Conciseness

Conciseness means using as few identifiers as possible under uniformity and meaningfulness. If meaning is compromised, it's better not to be concise. For instance, theOrderNameOfTheTargetSupplierWhichIsTransfered is too long; transferedTargetSupplierOrderName is better, whereas transTgtSplOrdNm is not. Avoid using abbreviations that omit vowels; our English is often not proficient enough to understand strange abbreviations.

#### 1.1.4 CamelCase Convention

In Java, except for package names, static constants, and other special cases, identifiers mostly follow the CamelCase convention. This means words are not separated by special characters but are distinguished by capitalizing the first letter of each word. For example: supplierName, addNewContract, not supplier_name, add_new_contract.

#### 1.1.5 English vs. Pinyin

Prefer using common and understandable English words. If unsure, consult team members. If necessary, use Chinese Pinyin, but avoid mixing Pinyin with English. For example, use "archive" rather than "pigeonhole" to represent archiving, and "guiDang" is acceptable if English is not feasible.

### 1.2 Package Names

Use lowercase letters for package names like com.xxx.settlement, not com.xxx.Settlement. Avoid using characters to separate words, e.g., com.xxx.settlement.jsfutil, not com.xxx.settlement.jsf_util.

### 1.3 Class Names

#### 1.3.1 Capitalize the First Letter

Class names should begin with a capital letter, e.g., SupplierService, PaymentOrderAction; not supplierService, paymentOrderAction.

#### 1.3.2 Suffixes

Class names often use different suffixes to express additional meanings, as shown in the table below:

| Suffix | Meaning | Example |
| ------ | ------- | ------- |
| Service | Indicates that this class is a service class, containing methods that provide business services to other classes | PaymentOrderService |
| Impl | This class is an implementation class, not an interface | PaymentOrderServiceImpl |
| Inter | This class is an interface | LifeCycleInter |
| Dao | This class encapsulates data access methods | PaymentOrderDao |
| Action | Handles page requests directly, managing page logic | UpdateOrderListAction |
| Listener | Class that responds to certain events | PaymentSuccessListener |
| Event | Represents a specific event | PaymentSuccessEvent |
| Servlet | A Servlet | PaymentCallbackServlet |
| Factory | Generates a certain type of object factory class | PaymentOrderFactory |
| Adapter | Used to connect to previously unsupported objects | DatabaseLogAdapter |
| Job | Represents a task that runs based on time | PaymentOrderCancelJob |
| Wrapper | This is a wrapper class designed to provide capabilities that a certain class does not have | SelectableOrderListWrapper |
| Bean | This is a POJO (Plain Old Java Object) | MenuStateBean |

### 1.4 Method Names

- Start with a lowercase letter, e.g., `addOrder()`, not `AddOrder()`.
- Place the verb in front, e.g., `addOrder()`, not `orderAdd()`.
- Verb prefixes often express specific meanings, as shown below:

| Prefix   | Meaning     | Example             |
| -------- | ----------- | ------------------- |
| create   | create      | createOrder()       |
| delete   | delete      | deleteOrder()       |
| add      | create      | addPaidOrder()      |
| remove   | delete      | removeOrder()       |
| init/initialize | initialize | initializeObjectPool() |
| destroy  | destroy     | destroyObjectPool() |
| open     | open        | openConnection()    |
| close    | close       | closeConnection()   |
| read     | read        | readUserName()      |
| write    | write       | writeUserName()     |
| get      | get         | getName()           |
| set      | set         | setName()           |
| prepare  | prepare     | prepareOrderList()  |
| copy     | copy        | copyCustomerList()  |
| modify   | modify      | modifyActualTotalAmount() |
| calculate| calculate   | calculateCommission() |
| do       | perform     | doOrderCancelJob()  |
| dispatch | determine   | dispatchUserRequest() |
| start    | start       | startOrderProcessing() |
| stop     | end         | stopOrderProcessing() |
| send     | send        | sendOrderPaidMessage() |
| receive  | receive     | receiveOrderPaidMessage() |
| respond  | respond     | responseOrderListItemClicked() |
| find     | find        | findNewSupplier()    |
| update   | update      | updateCommission()   |

In the business layer, the `find` method should preferably express business meaning, e.g., `findUnsettledOrders()` to query unsettled orders, rather than `findOrdersByStatus()`. In the data access layer, `find`, `update`, and other methods can express the SQL to be executed, e.g., `findByStatusAndSupplierIdOrderByName(Status.PAID, 345)`.


### 1.5 Field Names

#### 1.5.1 Static Constants

All uppercase with underscores separating words, like:

```java
public static final String ORDER_PAID_EVENT = "ORDER_PAID_EVENT";
```

#### 1.5.2 Enumerations

All uppercase with underscores, as in:

```java
public enum Events {
    ORDER_PAID,
    ORDER_CREATED
}
```

#### 1.5.3 Others

Start with lowercase, follow camelCase, for example:

```java
public String orderName;
```

### 1.6 Local Variables

Parameters and local variable names start with lowercase, using camelCase. Try to avoid conflicts with fields and express the variable's meaning within the method.

## 2. Code Formatting

Use spaces for code indentation, not tabs, with each level of indentation being 4 spaces.

### 2.1 Source File Encoding

Source files should use UTF-8 encoding, with Unix line endings.

### 2.2 Line Width

Lines should not exceed 80 characters. Follow Eclipse standards.

### 2.3 Package Imports

Remove unused imports and avoid importing entire packages. In Eclipse, use the shortcut `Ctrl+Shift+O` to manage imports.

### 2.4 Field Format

Declare only one field per line, with a blank line between field declarations.

### 2.5 Method Format

### 2.6 Code Block Format

#### 2.6.1 Indentation Style

Open curly braces on the same line as the block's start, and closing braces on a line with the same indentation level as the block's start. For example:

```java
package com.test;

public class TestStyle extends SomeClass implements AppleInter, BananaInter {

    public static final String THIS_IS_CONST = "CONST VALUE";

    private static void main(String[] args) {

        int localVariable = 0;

    }

    public void compute(String arg) {

        if (arg.length() > 0) {

            System.out.println(arg);

        }

        for (int i = 0; i < 10; i++) {

            System.out.println(arg);

        }

        while (condition) {
        }

        do {
            otherMethod();
        } while (condition);

        switch (i) {
            case 0:
                callFunction();
                break;
            case 1:
                callFunctionb();
                break;
            default:
                break;
        }
    }
}
```

#### 2.6.2 Space Usage

##### 2.6.2.1 Use a single space to separate elements:

Avoid:

```java
if       (               a >        b   )            {
    // do something here
};
```

##### 2.6.2.2 Use a single space around binary and ternary operators:

For example:

```java
a + b = c;
b - d = e;
return a == b ? 1 : 0;
```

Avoid:

```java
a+b=c;
b-d=e;
return a==b?1:0;
```

##### 2.6.2.3 After commas in statements, if not on a new line, follow with a single space:

For instance:

```java
call(a, b, c);
```

Avoid:

```java
call(a,b,c);
```

#### 2.6.3 Usage of Blank Lines

Blank lines can express the semantic separation of code, the scope of comments, and more. Group similar operations or a set of operations together without using blank lines to separate them, but use blank lines to separate different groups of code, like this:

```java
order = orderDao.findOrderById(id);

// update properties

order.setUserName(userName);
order.setPrice(456);
order.setStatus(PAID);
orderService.updateTotalAmount(order);
session.saveOrUpdate(order);
```

In the above example, the blank lines make the scope of comments very clear.

- Two consecutive blank lines represent a larger semantic division.
- Separate methods with blank lines.
- Separate fields with blank lines.
- If more than ten lines of code are not separated by blank lines, it will increase readability difficulties.

## 3. Comment Guidelines

### 3.1 Comments vs Code

- Comments should be concise and to the point, not excessive or misleading.
- Clear naming and structured code, where responsibilities of classes and methods are evident, often require minimal comments or none at all to be easily understood. Conversely, in chaotic code, no amount of comments can compensate. Therefore, effort should be placed primarily on the code itself.
- Comments that do not accurately convey the meaning of the code will only harm its readability.
- Excessively detailed comments, repetitive comments on obvious code, or verbose comments are better left unwritten.
- Comments should stay synchronized with the code; excessive comments can become a burden during development.
- Comments are not for managing code versions. If code is no longer needed, delete it directly. Version control systems like SVN will keep records. Do not comment out code, as it can confuse future developers about whether the commented code should be removed.

### 3.2 Java Doc

- Comments indicating the meaning and usage of classes, fields, and methods should be written in the JavaDoc style. JavaDoc is for the class users and primarily explains what something is and how to use it. Anything that class users need to know should be documented using JavaDoc. Non-JavaDoc comments are often for the code maintainer, focusing on why something is written a certain way, how to modify it, what issues to be aware of, etc.

Example:

```java
/**
 * This is a class comment
 */
public class TestClass {

    /**
     * This is a field comment
     */
    public String name;

    /**
     * This is a method comment
     */
    public void call() {
    }
}
```

### 3.3 Block-level Comments

#### 3.3.1 For block-level comments, use `//` for single-line comments and `/* ... */` for multi-line comments.

#### 3.3.2 Use a blank line to represent the scope of a comment for shorter code blocks.

#### 3.3.3 For longer code blocks, surround them with `/*------ start: ------*/` and `/*-------- end: -------*/`.

Example:

```java
/*----------start: Order Processing ------- */

// Get the DAO
OrderDao dao = Factory.getDao("OrderDao");

/* Retrieve the order */
Order order = dao.findById(456);

// Update the order
order.setUserName("uu");
order.setPassword("pass");
order.setPrice("ddd");
orderDao.save(order);

/*----------end: Order Processing ------- */
```


#### 3.3.4 Consider Using Braces to Indicate Comment Scope

Examples of using braces to denote the scope of comments:

```java
/*---------- Order Processing ------- */

{

    // Get the dao

    OrderDao dao = Factory.getDao("OrderDao");

    /* Query order */

    Order order = dao.findById(456);

    

    // Update order

    order.setUserName("uu");

    order.setPassword("pass");

    order.setPrice("ddd");

    

    orderDao.save(order);

}
```

### 3.4 Inline Comments

Inline comments are written at the end of the line using //

## 4 Best Practices and Taboos

### 4.1 Make Your Code Beautiful Every Time You Save

Programmers are lazy. Don't wait to optimize your code's format and structure after completing the functionality. Few people will be willing to go back and adjust the code once the functionality is complete.

### 4.2 Use Logging Instead of System.out.println()

Logging can set levels, control where output goes, and easily distinguish where in the code the print occurred, unlike System.out.print. Additionally, System.out.print is slow. Therefore, unless intentional, use logging. At least switch System.out.print to logging before committing to SVN.

### 4.3 Always Include Braces {} for each if, while, for statement

Consider the following code:

```java
if (a > b)
    a++;
```

If in the future maintenance requires incrementing b when a > b, a slight oversight might lead to:

```java
if (a > b)
    a++;
    b++;
```

This is incorrect because b++ will execute regardless of the relationship between a and b. If you initially write it like this:

```java
if (a > b) {
    a++;
}
```

It is unlikely anyone will mistakenly add b++. Additionally, the braces make the scope clearer, especially when the following line is long and needs to be wrapped.

### 4.4 Make Use of TODOs:

Include //TODO: in your code; most IDEs will prompt you about pending tasks. For example:

```java
if (order.isPaid()) {
    //TODO: Update order
}
```

### 4.5 Place an Empty Statement or Comment in Locations that Need to Remain Empty, Indicating Intentionally

For instance:

```java
if (!exists(order)) {
    ;
}
```

or:

```java
if (!exists(order)) {
    // nothing to do
}
```

### 4.6 Avoid Comparing Boolean Values to true/false

For example:

```java
if (order.isPaid() == true) {
    // Do something here
}
```

Instead of:

```java
if (order.isPaid()) {
    // Do something here
}
```

The latter is more readable; "if order is paid..." is easier to understand than "if order's isPaid method returns true...".

### 4.7 Reduce Code Nesting Levels

When the code nesting level exceeds 3 layers, it becomes difficult for most people to understand. The following code is a simple example:

```java
public void demo(int a, int b, int c) {

    if (a > b) {

        if (b > c) {

            doJobA();

        } else if (b < c) {

            doJobB()

        }

    } else {

        if (b > c) {

            if (a < c) {

                doJobC();

            }

        }

    }

}
```

There are several methods to reduce nesting:

- Combine conditions
- Utilize `return` to omit subsequent `else` blocks
- Use sub-methods

For example, after combining conditions, the code can be refactored as:

```java
public void demo(int a, int b, int c) {

    if (a > b && b > c) {

        doJobA();

    }

    if (a > b && c > b) {

        doJobB();

    }

    if (a <= b && c < b && a < c) {

        doJobC();

    }

}
```

If `return` is used, it would look like:

```java
public void demo(int a, int b, int c) {

    if (a > b) {

        if (b > c) {

            doJobA();
            return;

        }

        doJobB();
        return;

    }

    if (b > c) {

        if (a < c) {

            doJobC();

        }

    }

}
```

Utilizing sub-methods involves extracting nested code into separate methods.

### 4.8 Single Responsibility Principle

Separation of concerns is a fundamental principle in software development. Humans can tackle complex tasks by breaking them down into smaller, more focused tasks. Ensuring that program units have a single responsibility allows you to focus on fewer things while writing that part of the program, reducing complexity and minimizing errors.

### 4.9 Group Variable Declaration, Initialization, and Usage Together

For instance, consider the following code:

```java
int orderNum = getOrderNum();

// do something without orderNum here

call(orderNum);
```

The comment in the above example represents a segment of code that is unrelated to `orderNum`. The declaration, initialization, and usage of `orderNum` are spread across many lines of code, which is not ideal. It is better to do it this way:

```java
// do something without orderNum here

int orderNum = getOrderNum();

call(orderNum);
```

