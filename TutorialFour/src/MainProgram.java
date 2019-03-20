// TODO: Fix up the imports

import java.util.ArrayList;

public class MainProgram {
    public static void main(String[] args) {
        // produce myPets
        DatabaseHelper.databaseConnectCreate();
        DatabaseHelper.insertPets();
        ArrayList<Pet> myPets = DatabaseHelper.listAllPets();

        // header strings
        String[] headerStrings = {
                "ID", "Pet's Name", "Species", "Colour", "Owner's Name"
        };

        // generate HTML
        String preparedHtml = "<!DOCTYPE html>";
        preparedHtml += HtmlHelper.htmlHeadTag();
        preparedHtml += "<body>";
        preparedHtml += "<h1>My Pets</h1>";
        preparedHtml += "<table>";
        preparedHtml += HtmlHelper.htmlPetsTableHeader(headerStrings);
        for (Pet thisPet : myPets) {
            preparedHtml += "<tr>";
            preparedHtml += "<td>" + thisPet.getId() + "</td>";
            // TODO: Fill in the missing lines here
            preparedHtml += "<td>" + thisPet.getName() + "</td>";
            preparedHtml += "<td>" + thisPet.getColour() + "</td>";
            // HINT: Be careful with data types
            preparedHtml += "<td>"
                    + "<span style='color: " + thisPet.getColour() + "'>&#11044;</span> "
                    + thisPet.getColour()
                    + "</td>";
            preparedHtml += "<td>" + thisPet.getOwner() + "</td>";
            preparedHtml += "</tr>";
        }
        preparedHtml += "</table>";
        preparedHtml += "</body>";

        // print html
        HtmlHelper.replaceFileContents("index.html", preparedHtml);
    }
}