package Composite;

public abstract class Component {

    public void add(Component E){
        throw new UnsupportedOperationException();
    }

    public void remove(Component E){
        throw new UnsupportedOperationException();
    }

    public void getChild(){
        throw new UnsupportedOperationException();
    }

}
