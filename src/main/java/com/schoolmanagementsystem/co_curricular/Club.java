package com.schoolmanagementsystem.co_curricular;

public class Club implements CoCurricular{

    private String nameOfClub;
    private  String presidentID;
    private  String vicePresidentID;
    private String generalSecretaryID;
    private String treasurerID;
    private String clubModeratorID;
    private String assistantGSID;
    private String publicRelationsID;
    private String secretaryID;
    private String executive_1_ID;
    private String executive_2_ID;
    private String executive_3_ID;
    private String fundAmount;

    public String getNameOfClub() {
        return nameOfClub;
    }

    public String getPresidentID() {
        return presidentID;
    }

    public String getVicePresidentID() {
        return vicePresidentID;
    }

    public String getGeneralSecretaryID() {
        return generalSecretaryID;
    }

    public String getTreasurerID() {
        return treasurerID;
    }

    public String getClubModeratorID() {
        return clubModeratorID;
    }

    public String getAssistantGSID() {
        return assistantGSID;
    }

    public String getPublicRelationsID() {
        return publicRelationsID;
    }

    public String getSecretaryID() {
        return secretaryID;
    }

    public String getExecutive_1_ID() {
        return executive_1_ID;
    }

    public String getExecutive_2_ID() {
        return executive_2_ID;
    }

    public String getExecutive_3_ID() {
        return executive_3_ID;
    }

    public String getFundAmount() {
        return fundAmount;
    }


    public Club(String nameOfClub, String presidentID, String vicePresidentID, String generalSecretaryID, String treasurerID, String clubModeratorID, String assistantGSID, String publicRelationsID, String secretaryID, String executive_1_ID, String executive_2_ID, String executive_3_ID, String fundAmount) {
        this.nameOfClub = nameOfClub;
        this.presidentID = presidentID;
        this.vicePresidentID = vicePresidentID;
        this.generalSecretaryID = generalSecretaryID;
        this.treasurerID = treasurerID;
        this.clubModeratorID = clubModeratorID;
        this.assistantGSID = assistantGSID;
        this.publicRelationsID = publicRelationsID;
        this.secretaryID = secretaryID;
        this.executive_1_ID = executive_1_ID;
        this.executive_2_ID = executive_2_ID;
        this.executive_3_ID = executive_3_ID;
        this.fundAmount = fundAmount;
    }

    @Override
    public void addFund() {

    }

    @Override
    public void spendFund() {

    }

    @Override
    public void addMember() {

    }

    @Override
    public void removeMember() {

    }

    @Override
    public void ecPanel() {

    }

    @Override
    public void allMember() {

    }
}
