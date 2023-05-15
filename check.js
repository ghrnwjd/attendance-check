function init() {
    let today = new Date();

    let year = today.getFullYear();
    let month = today.getMonth() + 1;
    let date = today.getDate();

    let ghrnwjd = false;
    let mmmjunjoy = false;
    let cmsxi = false;
    let erica0321 = false;

    fetch("https://api.github.com/repos/ghrnwjd/ghrnwjd/commits")
  .then((response) => response.json())
  .then((data) => {
    let sen = "정호영은 " + attendanceCheck(data);
    let node = document.createElement("p");
    node.textContent = sen;
    document.getElementById("ghrnwjd").appendChild(node);
    ghrnwjd = true;
})
.catch((data) => {
    let node = document.createElement("p");
    node.textContent = "정호영은 아직 출석하지 못했습니다.";
    document.getElementById("ghrnwjd").appendChild(node);
  });

fetch("https://api.github.com/repos/mmmjunjoy/mmmjunjoy/commits")
  .then((response) => response.json())
  .then((data) => {
    let sen = "심준보는 " + attendanceCheck(data);
    let node = document.createElement("p");
    node.textContent = sen;
    document.getElementById("mmmjunjoy").appendChild(node);
    mmmjunjoy = true;
    })
  .catch((data) => {
    let node = document.createElement("p");
    node.textContent = "심준보는 아직 출석하지 못했습니다.";
    document.getElementById("mmmjunjoy").appendChild(node);
  });

fetch("https://api.github.com/repos/cmsxi/cmsxi/commits")
  .then((response) => response.json())
  .then((data) => {
    let sen = "최민서는 " + attendanceCheck(data);
    let node = document.createElement("p");
    node.textContent = sen;
    document.getElementById("cmsxi").appendChild(node);
    cmsxi = true;
})
.catch((data) => {
    let node = document.createElement("p");
    node.textContent = "최민서는 아직 출석하지 못했습니다.";
    document.getElementById("cmsxi").appendChild(node);
  });

fetch("https://api.github.com/repos/erica0321/erica0321/commits")
  .then((response) => response.json())
  .then((data) => {
    let sen = "노현아는 " + attendanceCheck(data);
    let node = document.createElement("p");
    node.textContent = sen;
    document.getElementById("erica0321").appendChild(node);
    erica0321 = true;
})
  .catch((data) => {
    let node = document.createElement("p");
    node.textContent = "노현아는 아직 출석하지 못했습니다.";
    document.getElementById("erica0321").appendChild(node);
  }); 

}


function attendanceCheck(x) {
    x = x[0].commit.author.date
    x = x.substr(0, 10);
    year_month_day = x.split('-');

    let today_year = parseInt(year_month_day[0]);
    let today_month = parseInt(year_month_day[1]);
    let today_date = parseInt(year_month_day[2]);
    
    
    if(year === today_year && month === today_month && date === today_date) {
        return "출석 하였습니다.";
    }

    return "아직 출석하지 못했습니다.";
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

init();
// readFile();