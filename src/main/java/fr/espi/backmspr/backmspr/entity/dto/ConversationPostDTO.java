package fr.espi.backmspr.backmspr.entity.dto;

public class ConversationPostDTO {

    private long user_id1;
    private long user_id2;

    public ConversationPostDTO(long user_id1, long user_id2) {
        this.user_id1 = user_id1;
        this.user_id2 = user_id2;
    }

    public long getUser_id1() {
        return user_id1;
    }

    public long getUser_id2() {
        return user_id2;
    }

    public void setUser_id1(long user_id1) {
        this.user_id1 = user_id1;
    }

    public void setUser_id2(long user_id2) {
        this.user_id2 = user_id2;
    }
}
