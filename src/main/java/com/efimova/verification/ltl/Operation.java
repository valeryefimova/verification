package com.efimova.verification.ltl;


public enum Operation {
    CON {
        public String toString() {
            return " && ";
        }
    },
    DIS {
        public String toString() {
            return " || ";
        }
    },
    RELEASE {
        public String toString() {
            return " R ";
        }
    },
    UNTIL {
        public String toString() {
            return " U ";
        }
    }
}
