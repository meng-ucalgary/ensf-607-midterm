public class MVCString {
    public static void main (String [] args)
    {
        StringView theView = new StringView();
        StringModel theModel = new StringModel ();
        StringController theController = new StringController (theView, theModel);

        theView.setVisible(true);
    }
}
