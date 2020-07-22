public class Main {
    public static void main(String[] args) {

        PersonAPI personAPI = new PersonAPI("https://crudcrud.com/api/0068076092c94e3f9b0534fb37f8b422");

//        personAPI.postPerson(new Person("Aziz"));
//        personAPI.putPerson("5f182b059a729803e8b2bfbe", new Person("Super Tech Lead Aziz"));

        personAPI.deletePerson("5f182bd39a729803e8b2bfc1");
        Person[] result = personAPI.getPeople();

        for (Person person : result) {
            System.out.println(person);
        }

    }
}
