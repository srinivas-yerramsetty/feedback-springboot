let selectedRating = 3;

const ratingButtons = document.querySelectorAll(".rating-btn");


/* Rating Selection */

ratingButtons.forEach(button => {

    button.addEventListener("click", () => {

        ratingButtons.forEach(btn => {
            btn.classList.remove("active");
        });

        button.classList.add("active");

        selectedRating = button.innerText;
    });
});


/* Submit Feedback */

async function submitFeedback(event){

    event.preventDefault();

    const studentName = document.getElementById("studentName").value;

    const department = document.getElementById("department").value;

    const message = document.getElementById("message").value;


    const data = {

        studentName: studentName,

        department: department,

        rating: selectedRating,

        message: message
    };


    try{

        const response = await fetch("/feedback", {

            method:"POST",

            headers:{
                "Content-Type":"application/json"
            },

            body: JSON.stringify(data)
        });


        if(response.ok){

            document.getElementById("successPopup")
            .classList.add("active");

            document.getElementById("studentName").value = "";

            document.getElementById("department").value = "";

            document.getElementById("message").value = "";
        }

    }catch(error){

        alert("Server Error");
    }
}


/* Close Popup */

function closePopup(){

    document.getElementById("successPopup")
    .classList.remove("active");
}