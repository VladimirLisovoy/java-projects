package ua.lisovoy.data_stucture.list;

import ua.lisovoy.data_structure.list.LinkedList;
import ua.lisovoy.data_structure.list.List;

/**
 * Created by vladimir on 11/30/2016.
 */
public class LinkedListTest extends AbstractListTest {

    @Override
    public List getList() {
        return new LinkedList();
    }
}
