package Iterator;

import Composite.Component;
import Composite.User;

import java.util.List;

public class DevelopmentIterator implements Iterator{

    private List<User> developmetnUser;
    private int Index = 0;

    public DevelopmentIterator(List<User> developmetnUser) {
        this.developmetnUser = developmetnUser;
    }

    @Override
    public Boolean hasNext() {
        return Index < developmetnUser.size();
    }

    @Override
    public User next() {
        if(!hasNext()){
            throw new java.util.NoSuchElementException();
        }
        return developmetnUser.get(Index++);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
