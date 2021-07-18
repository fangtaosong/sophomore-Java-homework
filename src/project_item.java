public class project_item {
    int id;
    String name;
    String member_1;
    String member_2;
    String member_3;
    String member_4;
    String member_5;
    String stage;
    String projectlevel;
    String fileid;
    boolean error_type;
    project_item(int id,
            String name,
            String member_1,
            String member_2,
            String member_3,
            String member_4,
            String member_5,
            String stage,
            String projectlevel,
            String fileid     )
    {
        this.id=id;
        this.name=name;
        this.member_1=member_1;
        this.member_2=member_2;
        this.member_3=member_3;
        this.member_4=member_4;
        this.member_5=member_5;
        this.stage=stage;
        this.projectlevel=projectlevel;
        this.fileid=fileid;
        this.error_type=false;

    }

    public project_item(String error) {
        error_type=true;

    }

    String getinfo(){
        if (!error_type)
        {
            return "&Pid="+ this.id+
                    "&Pname="+ this.name+
                    "&member_1="+ this.member_1+
                    "&member_2="+ this.member_2+
                    "&member_3="+this.member_3+
                    "&member_4="+this.member_4+
                    "&member_5="+this.member_5+
                    "&stage="+this.stage+
                    "&projectlevel="+this.projectlevel+
                    "&fileid="+this.fileid;
        }
        else
        {
            return "&notFound";
        }
    }

    public String getName() {
        return name;
    }

    public String getMember_1() {
        return member_1;
    }

    public String getMember_2() {
        return member_2;
    }

    public String getMember_3() {
        return member_3;
    }

    public String getMember_4() {
        return member_4;
    }

    public String getMember_5() {
        return member_5;
    }

    public String getStage() {
        return stage;
    }

    public String getProjectlevel() {
        return projectlevel;
    }

    public String getId() {
        return String.valueOf(id);
    }
}
