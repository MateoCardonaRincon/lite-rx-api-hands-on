package io.pivotal.literx;

import org.w3c.dom.ranges.Range;
import reactor.core.publisher.Flux;

import java.sql.SQLOutput;
import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.List;

/**
 * Learn how to create Flux instances.
 *
 * @author Sebastien Deleuze
 * @see <a href="https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html">Flux Javadoc</a>
 */
public class Part01Flux {

//========================================================================================

    // TODO Return an empty Flux
    Flux<String> emptyFlux() {
        return Flux.empty();
    }

//========================================================================================

    // TODO Return a Flux that contains 2 values "foo" and "bar" without using an array or a collection
    Flux<String> fooBarFluxFromValues() {
        return Flux.just("foo").concatWith(Flux.just("bar"));
    }

//========================================================================================

    // TODO Create a Flux from a List that contains 2 values "foo" and "bar"
    Flux<String> fooBarFluxFromList() {
        return Flux.fromIterable(List.of("foo", "bar"));
    }

//========================================================================================

    // TODO Create a Flux that emits an IllegalStateException
    Flux<String> errorFlux() {
        return Flux.error(IllegalStateException::new);
    }

//========================================================================================

    // TODO Create a Flux that emits increasing values from 0 to 9 each 100ms
    Flux<Long> counter() {
        return Flux.just(0L, 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L)
                .delayElements(Duration.ofMillis(100))
                .doOnNext(e -> System.out.println("delayed element: " + e));
    }

}
