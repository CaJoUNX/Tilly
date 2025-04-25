package org.media.tilly;

public class AuthenticationProcess {
        private boolean success = false;
        public AuthenticationProcess(String pin) {
            //insert DB method here
            if (pin.equals("1234")) {
                success = true;

            }
            else {
                success = false;

            }

        }
        public boolean success() {
            return success;
        }
}
