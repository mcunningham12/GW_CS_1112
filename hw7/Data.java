/*-------------------------------------------------------------------------
This class encapsulates show data for a show catelog.

author: James Levy, James Taylor
-------------------------------------------------------------------------*/
public class Data {
    // the show reference is final because it is not allowed to change
    // after construction.  To change shows, must create a new instance.
    // prevents the need to create an separate accessor.
    public final String show;

    // Parameterized constructor requires the show be assigned at creation
    // @param show the show to store in this instance
    public Data(String show) {
        this.show = show;
    }

    // Equivalent to a less than operator.  Evaluates whether or not the 
    // information stored inside this instance is 'less than' the parameter
    // @param data a data instance to compare to this instance.
    // @returns true if this instance is 'less than' the parameter; 
    //          otherwise, false.  
    public boolean lessThan(Data data) {
        assert(data != null);

        if(show.compareTo(data.show) < 0) {
            return true;
        }
        return false;
    }

    // Equivalent to a less than or equal to operator.  Evaluates whether 
    // or not the information stored inside this instance is 
    // 'less than or equal to' the parameter
    // @param data a data instance to compare to this instance.
    // @returns true if this instance is 'less than or equal to' the 
    //          parameter; otherwise, false.  
    public boolean lessThanOrEqual(Data data) {
        assert(data != null);

        if(show.compareTo(data.show) <= 0) {
            return true;
        }
        return false;
    }

    // Comparison function
    // @param show a show to compare to the show stored in this instance
    // @returns -1 if this instance preceeds the parameter, 1 if this 
    //          instance follows the parameter, 0 if the two are equivalent
    public int compareTo(String show) {
        assert(show != null);

        return this.show.compareTo(show);
    }
}
