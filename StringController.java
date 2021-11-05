import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StringController {
	private StringView theView;
	private StringModel theModel;

	public StringController(StringView v, StringModel m) {
		theView = v;
		theModel = m;

		theView.addStringListener(new StringListener());
	}

	class StringListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String first, sec;
			try {
				first = theView.getFirstString();
				sec = theView.getSecString();

				theModel.concatenate(first, sec);

				theView.setResult(theModel.getMyString());
			}

			catch (Exception ex) {
				theView.displayErrorMessage("Error!");
			}
		}
	}
}
