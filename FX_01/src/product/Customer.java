package product;

import com.mongodb.DBObject;
import org.bson.BSONObject;

import java.util.Map;
import java.util.Set;

public class Customer implements DBObject {

    private Map<String,Object> data;
    private boolean partial;
    

    public Customer(Map<String, Object> data) {
        this.data = data;
    }

    @Override
    public void markAsPartialObject() {

    }

    @Override
    public boolean isPartialObject() {
        return false;
    }

    @Override
    public Object put(String s, Object o) {
        return null;
    }

    @Override
    public void putAll(BSONObject bsonObject) {

    }

    @Override
    public void putAll(Map map) {

    }

    @Override
    public Object get(String s) {
        return null;
    }

    @Override
    public Map toMap() {
        return null;
    }

    @Override
    public Object removeField(String s) {
        return null;
    }

    @Override
    public boolean containsKey(String s) {
        return false;
    }

    @Override
    public boolean containsField(String s) {
        return false;
    }

    @Override
    public Set<String> keySet() {
        return null;
    }
}
