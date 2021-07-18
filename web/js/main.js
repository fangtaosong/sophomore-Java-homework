function getQueryVariable(variable)
{
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i=0;i<vars.length;i++) {
        var pair = vars[i].split("=");
        if(pair[0] == variable){return pair[1];}
    }
    return(false);
}

alert(getQueryVariable('id')+getQueryVariable('pw1'))
console.log(getQueryVariable('id'));
console.log(getQueryVariable('pw1'));

onload()
{
    var temp=a();
    console.log(temp);
}
function a()
{
    var project = {}

    project.name=getQueryVariable('name')
    project.id=getQueryVariable('id')
    project.Pname=getQueryVariable('Pname')
    project.Pid=getQueryVariable('Pid')
    project.pw1=getQueryVariable('pw1')
    project.projectID=getQueryVariable('Pid')
    project.member=[]
    project.member[0]=getQueryVariable('member_1')
    project.member[1]=getQueryVariable('member_2')
    project.member[2]=getQueryVariable('member_3')
    project.member[3]=getQueryVariable('member_4')
    project.member[4]=getQueryVariable('member_5')
    project.member_1=getQueryVariable('member_1')
    project.member_2=getQueryVariable('member_2')
    project.member_3=getQueryVariable('member_3')
    project.member_4=getQueryVariable('member_4')
    project.member_5=getQueryVariable('member_5')
    var stageset = ['申报阶段','开题阶段','开发阶段','中期阶段','结项阶段']
    var Levelset = ['国家级','省级','校级','院级','寝室级']
    project.stage=stageset[getQueryVariable('stage')-1]
    project.projectlevel=Levelset[getQueryVariable('projectlevel')-1]
    project.fileid=getQueryVariable('fileid')
    console.log(project);
    return project
}