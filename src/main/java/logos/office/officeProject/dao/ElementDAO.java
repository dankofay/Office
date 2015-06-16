package logos.office.officeProject.dao;

import java.util.*;

public interface ElementDAO<E> {

	public void addElement(E element);
	
    public void updateElement(E element);
    
    public void deleteElement(E element);
    
    public E getElementByID(Long elementId);
    
    public List<E> getAllElements();

}
