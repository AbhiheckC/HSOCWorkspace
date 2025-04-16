// Create a function to change
    // the hash value of the page
    function changeLanguage(lang) {
      location.hash = lang;
      location.reload();
    }
    console.log(location.hash)
  
    // Define the language reload anchors
    var language = {
      eng: {
        login: "Log In"
      },
      hin: {
        login: "लॉग इन"
      }
    };
  
    // Check if a hash value exists in the URL
    if (window.location.hash) {
  
      // Set the content of the webpage 
      // depending on the hash value
      if (window.location.hash == "#eng"){
		document.querySelector("#loginHeading").innerHTML ="Log In";
       //document.getElementsByName('Email')[0].placeholder=language.eng.login;
          
      }
      else if (window.location.hash == "#hin") {
       //document.getElementsByName('Email')[0].placeholder=language.hin.login;
       document.querySelector("#loginHeading").innerHTML ="लॉग इन";
      }
    }