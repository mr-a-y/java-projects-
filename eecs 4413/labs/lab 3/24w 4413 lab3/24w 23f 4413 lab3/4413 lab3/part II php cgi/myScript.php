<!DOCTYPE html>
<html lang="en">
<head>
    <title>Form Submission Result</title>
</head>
<body>
    Hi <b><?php echo $_GET["firstName"]; ?></b>, the server has received your form submission successfully. <hr>

    Welcome <b><?php echo $_GET["firstName"]; ?></b> <b><?php echo $_GET["lastName"]; ?></b> <br>
    Your email address is: <b><?php echo $_GET["email"]; ?></b><br><br>

    Your program is: <b><?php echo $_GET["program"]; ?> </b> <br>

    You are in year: <b> <?php echo isset($_GET["year"]) ? $_GET["year"] : "N/A"; ?></b> <br>

    Your hobbies: <b>
        <?php
        if (isset($_GET["hobby"])) {
            $hobbies = $_GET["hobby"];
            foreach ($hobbies as $value) {
                echo "" . $value . "  ";
            }
        } else {
            echo "N/A";
        }
        ?>
    </b>
    <br><br>

    Your comments: <b><?php echo $_GET["comment"]; ?></b><br><br>

    <hr>
    Good luck with your studies in the 2023-24 academic year, <b><?php echo $_GET["firstName"]; ?></b>! <hr>
</body>
</html>
