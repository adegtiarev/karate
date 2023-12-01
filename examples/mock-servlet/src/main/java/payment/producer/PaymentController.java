/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Project: https://karatelabs.github.io/karate
*    Release: https://github.com/karatelabs/karate/releases/tag/v1.3.1
*    Source File: PaymentController.java
*    
*    Copyrights:
*      copyright 2017 intuit inc
*      copyright 2020 pthomas3
*      copyright 2011-2019 the bootstrap authors (https://github.com/twbs/bootstrap/graphs/contributors)
*    
*    Licenses:
*      MIT License
*      SPDXId: MIT
*    
*    Auto-attribution by Threatrix, Inc.
*    
*    ------ END LICENSE ATTRIBUTION ------
*/
package payment.producer;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pthomas3
 */
@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final AtomicInteger counter = new AtomicInteger();
    private final Map<Integer, Payment> payments = new ConcurrentHashMap();

    @PostMapping
    public Payment create(@RequestBody Payment payment) {
        int id = counter.incrementAndGet();
        payment.setId(id);
        payments.put(id, payment);
        return payment;
    }

    @PutMapping("/{id:.+}")
    public Payment update(@PathVariable int id, @RequestBody Payment payment) {
        payments.put(id, payment);
        return payment;
    }

    @GetMapping
    public Collection<Payment> list() {
        return payments.values();
    }

    @GetMapping("/{id:.+}")
    public Payment get(@PathVariable int id) {
        return payments.get(id);
    }

    @DeleteMapping("/{id:.+}")
    public void delete(@PathVariable int id) {
        Payment payment = payments.remove(id);
        if (payment == null) {
            throw new RuntimeException("payment not found, id: " + id);
        }
    }

}
