package combinatorpattern;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegistrationValidator.*;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+48535325",
                LocalDate.of(2000, 1, 1));

        CustomerValidatorService validatorService = new CustomerValidatorService();
        //now if error then cannot simply check where the error appears
        System.out.println("imperative approach: " + validatorService.isAllCustomerValid(customer));

        //if data is not valid (any error appears) then simply check where the error is by using the combination pattern
        //Combinator pattern:
        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult())
                .apply(customer); // !!

        System.out.println("Declarative approach with using interface and lambdas: " + result);
//        if (result != ValidationResult.SUCCESS){
//            throw new IllegalStateException(result.name());
//        }


    }

}
