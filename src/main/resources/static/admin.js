async function loadFeedback(){

    const response = await fetch("/feedback");

    const data = await response.json();

    const container = document.getElementById("feedbackContainer");

    let totalRating = 0;

    document.getElementById("totalFeedback").innerText = data.length;

    data.forEach(feedback => {

        totalRating += feedback.rating;

        container.innerHTML += `

            <div class="feedback-card">

                <h3>${feedback.studentName}</h3>

                <p><strong>Department:</strong> ${feedback.department}</p>

                <p><strong>Rating:</strong> ⭐ ${feedback.rating}</p>

                <p>${feedback.message}</p>

            </div>

        `;
    });


    const average = (totalRating / data.length).toFixed(1);

    document.getElementById("averageRating").innerText = average;
}

loadFeedback();