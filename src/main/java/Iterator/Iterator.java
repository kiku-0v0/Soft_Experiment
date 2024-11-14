package Iterator;

import Composite.Component;

public interface Iterator {
    public Boolean hasNext();


    public Component next();

    public void remove();
}
