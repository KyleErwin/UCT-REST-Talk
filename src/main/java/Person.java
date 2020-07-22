import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {

    String _id;
    String name;

    @JsonCreator
    public Person(@JsonProperty("_id") String _id, @JsonProperty("name") String name) {
        this.name = name;
        this._id = _id;
    }

    public Person(String name) {
        this.name = name;
        this._id = null;
    }

    @JsonIgnore
    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "_id='" + _id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
