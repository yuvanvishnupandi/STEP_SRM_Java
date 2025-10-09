// File: VotingSystem.java
public class VotingSystem {
    public void processVote(String voterId, String candidate) {
        
        class VoteValidator {
            private final String ID_PREFIX = "VTR";
            
            public boolean validate() {
                return voterId != null && voterId.startsWith(ID_PREFIX);
            }
        }
        
        VoteValidator validator = new VoteValidator();
        if (validator.validate()) {
            System.out.println("Voter ID '" + voterId + "' is valid. Vote for " + candidate + " recorded.");
        } else {
            System.out.println("Voter ID '" + voterId + "' is invalid.");
        }
    }

    public static void main(String[] args) {
        VotingSystem vs = new VotingSystem();
        vs.processVote("VTR12345", "Candidate A");
        vs.processVote("INV98765", "Candidate B");
        vs.processVote(null, "Candidate C");
    }
}