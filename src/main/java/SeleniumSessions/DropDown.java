package SeleniumSessions;

//NOT able to understand it

public enum DropDown {

	INDEX {
		@Override
		public String toString() {
			return "index";
		}
	},

	VALUE {
		@Override
		public String toString() {
			return "value";
		}
	},

	VISIBLETEXT {
		@Override
		public String toString() {
			return "visibletext";
		}
	}

}
