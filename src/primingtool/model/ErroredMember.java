package primingtool.model;

public class ErroredMember{

    private String erroredMemberEntity;

    public ErroredMember(String erroredMemberEntity) {
        this.setErroredMemberEntity(erroredMemberEntity);
    }


    public String getErroredMemberEntity() {
        return erroredMemberEntity;
    }

    public void setErroredMemberEntity(String erroredMemberEntity) {
        this.erroredMemberEntity = erroredMemberEntity;
    }
}
