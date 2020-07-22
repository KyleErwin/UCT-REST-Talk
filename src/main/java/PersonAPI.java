import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import static org.springframework.web.reactive.function.client.WebClient.builder;

public class PersonAPI {

    private String baseUrl;

    private WebClient webClient;

    public PersonAPI(String baseUrl) {
        this.baseUrl = baseUrl;

        this.webClient = builder()
                .baseUrl(baseUrl)
                .build();

    }


    public Person[] getPeople() {
        return webClient
                .get()
                .uri("/people")
                .retrieve()
                .bodyToMono(Person[].class)
                .block();
    }

    public Person getPerson(String id) {
        return webClient
                .get()
                .uri("/people/5f17ee709a729803e8b2bfa7")
                .retrieve()
                .bodyToMono(Person.class)
                .block();
    }

    public void postPerson(Person person) {
        webClient
                .post()
                .uri("/people")
                .body(BodyInserters.fromValue(person))
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    public void putPerson(String id, Person person) {
        webClient
                .put()
                .uri("/people/" + id)
                .body(BodyInserters.fromValue(person))
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    public void deletePerson(String id) {
        webClient
                .delete()
                .uri("/people/" + id)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }
}
