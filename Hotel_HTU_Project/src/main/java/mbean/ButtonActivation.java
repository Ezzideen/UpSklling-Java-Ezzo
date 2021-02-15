package mbean;

import com.jk.web.faces.mb.JKManagedBean;

public abstract class ButtonActivation extends JKManagedBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5L;

	// --------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------

	public enum Mode {

		ADD, EDIT, READONLY
	}

	// --------------------------------------------------------------------------------------------------------------------

	public ButtonActivation() {
		setAddMode();
	}

	// --------------------------------------------------------------------------------------------------------------------

	private Mode activeMode;

    // Setter
	public Mode getActiveMode() {
		return activeMode;
	}
	 // Getter
	public void setActiveMode(Mode activeMode) {
		this.activeMode = activeMode;
	}

	// --------------------------------------------------------------------------------------------------------------------

	// Boolean Methods
	public boolean isEditMode() {
		return getActiveMode() == Mode.EDIT;
	}

	public boolean isReadOnlyMode() {
		return getActiveMode() == Mode.READONLY;
	}

	public boolean isAddMode() {
		return getActiveMode() == Mode.ADD;
	}

	// --------------------------------------------------------------------------------------------------------------------
    // Action Methods
	public void setAddMode() {
		setActiveMode(Mode.ADD);
	}
	public void setEditMode() {
		setActiveMode(Mode.EDIT);
	}
	public void setReadOnlyMode() {
		setActiveMode(Mode.READONLY);
	}
	
}
