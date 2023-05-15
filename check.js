let year, month, date;
let ghrnwjd, mmmjunjoy, cmsxi, erica0321;


function init() {
    let today = new Date();

    year = today.getFullYear();
    month = today.getMonth() + 1;
    date = today.getDate();

    ghrnwjd = false;
    mmmjunjoy = false;
    cmsxi = false;
    erica0321 = false;
    

    ghrnwjdAPI();
    junjoyAPI();
    xiAPI();
    noAPI();
}

function ghrnwjdAPI() {
    fetch("https://api.github.com/repos/ghrnwjd/ghrnwjd/commits")
    .then((response) => response.json())    
    .then((data) => {
        let node = attendanceCheck(data);
        document.getElementById("ghrnwjd").appendChild(node);
        ghrnwjd = true; 
    })
    .catch((error) => {
        let node = document.createElement("p");
        node.textContent = "정호영은 아직 출석하지 못했습니다.";
        document.getElementById("ghrnwjd").appendChild(node);
    });
}


function junjoyAPI() {
    fetch("https://api.github.com/repos/mmmjunjoy/mmmjunjoy/commits")
    .then((response) => response.json())
    .then((data) => {
        let node = attendanceCheck(data);
        document.getElementById("mmmjunjoy").appendChild(node);
        mmmjunjoy = true;
    })
    .catch((error) => {
        let node = document.createElement("p");
        node.textContent = "심준보는 아직 출석하지 못했습니다.";
        document.getElementById("mmmjunjoy").appendChild(node);
    });
}

function xiAPI() {
    fetch("https://api.github.com/repos/cmsxi/cmsxi/commits")
    .then((response) => response.json())
    .then((data) => {
        let node = attendanceCheck(data);
        document.getElementById("cmsxi").appendChild(node);
        cmsxi = true;
    })
    .catch((error) => {
        let node = document.createElement("p");
        node.textContent = "최민서는 아직 출석하지 못했습니다.";
        document.getElementById("cmsxi").appendChild(node);
        
    });
}


function noAPI() {
    fetch("https://api.github.com/repos/erica0321/erica0321/commits")
    .then((response) => response.json())
    .then((data) => {
        let node = attendanceCheck(data);
        document.getElementById("erica0321").appendChild(node);
        erica0321 = true;
    })
    .catch((error) => {
        let node = document.createElement("p");
        node.textContent = "노현아는 아직 출석하지 못했습니다.";
        document.getElementById("erica0321").appendChild(node);
    });
}





function attendanceCheck(x) {
    x = x[0].commit.author.date
    let temp = x.substr(0, 10);
    
    let hour = parseInt(x.substr(11, 13));
    let minutes = parseInt(x.substr(14,16));

    year_month_day = temp.split('-');       
    
    let today_year = parseInt(year_month_day[0]);
    let today_month = parseInt(year_month_day[1]);
    let today_date = parseInt(year_month_day[2]);

    let gitTime = setLocalTime(today_year, today_month, today_date, hour);
    
    console.log(gitTime[1] + "월 " + gitTime[2] + "일 " + gitTime[3] +"시 " + minutes);

    let node = document.createElement("div");
    

    if(year === gitTime[0] && month === gitTime[1] && date === gitTime[2]) {
        node.innerHTML = "출석 하였습니다.<br/>최근 커밋 시간은 "+ gitTime[1] + "월 " + gitTime[2] + "일 " + gitTime[3] +"시 " + minutes + "분" + "입니다. ";;
    }
    else{
        node.innerHTML = "아직 출석하지 못했습니다.<br/> 최근 커밋 시간은 "+ gitTime[1] + "월 " + gitTime[2] + "일 " + gitTime[3] +"시 " + minutes + "분" + "입니다.";
    }

    return node;
}

function createFile() {
    var fileObject = new ActiveXObject("Scripting.FileSystemObject");
    
    fWrite = fileObject.CreateTextFile(__dirname + "/database.txt");
    fWrite.write("정호영: ");
    fWrite.write("심준보: ");
    fWrite.write("최민서: ");
    fWrite.write("노현아: ");


    fWrite.close();

}

function readFile() {
    var fileName = __dirname + "/database.txt";
    var fileObject = new ActiveXObject("Scripting.FileSystemObject");

    if(!fileObject.FileExists(fileName)) {
        createFile();
    }

    let ghrnwjd_contents;
    let mmmjunjoy_contents;
    let cmsxi_contents;
    let erica0321_contents;

    var fOpen = fileObject.OpenTextFile(fileName, 1);
    while(!fOpen.AtEndOfStream) {
        let x = fOpen.Readline();

        if(x.includes("정호영") && ghrnwjd) {
            ghrnwjd_contents = x + month + "-" + date + ",";
        }
        if(x.includes("심준보") && mmmjunjoy) {
            mmmjunjoy_contents = x + month + "-" + date + ",";

        }
        if(x.includes("최민서") && cmsxi) {
            cmsxi_contents = x + month + "-" + date + ",";

        }
        if(x.includes("노현아") && erica0321) {
            erica0321_contents = x + month + "-" + date + ",";
        }
    }
}

function updateFile(ghrnwjd_contents, mmmjunjoy_contents, cmsxi_contents, erica0321_contents) {
    
    var fileObject = new ActiveXObject("Scripting.FileSystemObject");
    
    fWrite = fileObject.CreateTextFile(__dirname + "/database.txt");
    
    fWrite.write(ghrnwjd_contents);
    fWrite.write(mmmjunjoy_contents);
    fWrite.write(cmsxi_contents);
    fWrite.write(erica0321_contents);


    fWrite.close();

}


// readFile();

function setLocalTime(year, month, date, hour) {
    var gitDate = new Date(year, month -1, date, hour);

    var localDate = new Date(gitDate.getTime() + (9 * 60 * 60 * 1000));

    var localYear = localDate.getFullYear();
    var localMonth = localDate.getMonth() + 1;
    var localDay = localDate.getDate();
    var localHour = localDate.getHours();

    return [localYear, localMonth, localDay, localHour];
}

init();