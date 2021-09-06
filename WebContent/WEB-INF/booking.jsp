<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="bean.Hotel"%>
    <%@page import="bean.User"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/090a7dfca4.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="style.css" />
    <title>Information about Hotel</title>
</head>
<body>
    <header class="header">
        <div class="header__logo">
            <svg width="216.73398096612857" height="39.800000000000004" viewBox="0 0 216.73398096612857 39.800000000000004" 
                class="css-1j8o68f">
                <defs id="SvgjsDefs5193"></defs>
                <g id="SvgjsG5194" featurekey="nameLeftFeature-0" transform="matrix(1.6249999354283042,0,0,1.6249999354283042,-1.2999994834264326,3.575000064571695)" fill="#111111">
                    <path d="M11.46 14.280000000000001 l0 2.74 l-1.5 0 l0 2.98 l-3.22 0 l0 -2.98 l-5.94 0 l0 -2.74 l5.94 -8.28 l3.22 0 l0 8.28 l1.5 0 z M4.1 14.280000000000001 l2.64 0 l0 -3.98 z M21.32 12.219999999999999 c1.4 0.4 2.84 1.66 2.84 3.66 c0 2.56 -1.6 4.12 -5.1 4.12 l-5.7 0 l0 -14 l5.32 0 c2.94 0 4.42 1.66 4.42 3.54 c0 1.54 -1 2.32 -1.78 2.68 z M18.38 8.8 l-1.8 0 l0 2.5 l1.8 0 c1.14 0 1.52 -0.52 1.52 -1.26 c0 -0.8 -0.48 -1.24 -1.52 -1.24 z M18.88 17.2 c1.42 0 2.06 -0.6 2.06 -1.74 c0 -0.96 -0.64 -1.58 -2.22 -1.58 l-2.14 0 l0 3.32 l2.3 0 z M33.86 20 l-2.86 -4.58 l-1.72 0 l0 4.58 l-3.22 0 l0 -14 l4.98 0 c3.14 0 5.22 1.9 5.22 4.82 c0 1.86 -0.88 3.26 -2.36 3.98 l3.36 5.2 l-3.4 0 z M29.28 8.96 l0 3.72 l1.56 0 c1.3 0 2.2 -0.46 2.2 -1.86 c0 -1.38 -0.9 -1.86 -2.2 -1.86 l-1.56 0 z M46.04 5.800000000000001 c3.96 0 7.28 2.94 7.28 7.2 s-3.32 7.2 -7.28 7.2 s-7.28 -2.94 -7.28 -7.2 s3.32 -7.2 7.28 -7.2 z M46.04 17.18 c2.26 0 3.94 -1.76 3.94 -4.18 s-1.68 -4.18 -3.94 -4.18 s-3.92 1.76 -3.92 4.18 s1.66 4.18 3.92 4.18 z"></path>
                </g>
                <g id="SvgjsG5195" featurekey="inlineSymbolFeature-0" transform="matrix(0.5133854401869956,0,0,0.5133854401869956,86.09317687903832,-2.124094883062183)" fill="#111111">
                    <path xmlns="http://www.w3.org/2000/svg" d="M93.167,31.646c-0.755-1.725-1.648-3.644-2.905-5.067c-1.078-1.221-2.568-1.442-3.643-0.102  c-1.096,1.368-1.403,3.336-1.608,5.025c-0.066,0.554-0.108,1.135-0.397,1.627c-0.445,0.758-1.59,1.158-2.379,0.808  c-1.062-0.472-1.134-1.617-1.257-2.617c-0.14-1.138-0.419-2.223-1.262-3.064c-0.722-0.721-2.141-0.842-2.991-0.296  c-0.788,0.504-0.865,1.849-0.928,2.673c-0.1,1.309,0.095,2.626-0.038,3.928c-0.132,1.277-1.386,2.625-2.615,1.456  c-0.482-0.459-0.587-1.156-0.728-1.774c-0.328-1.445-1.159-4.817-3.21-4.521c-0.776,0.112-1.607,0.7-1.846,1.48  c-0.263,0.857-0.397,1.758-0.539,2.641c-0.166,1.04,0.134,2.651-0.785,3.399c-0.751,0.61-1.856,0.852-2.54,1.537  c-0.139,0.14-0.261,0.297-0.359,0.481c-0.049,0.091-0.098,0.182-0.147,0.273c-1.996-2.666-5.263-4.816-10.507-5.247  C45.191,33.686,41,36.508,39,39.947c0,0,0-0.001,0-0.001c0-0.092-0.112-0.177-0.19-0.256c-0.677-0.692-1.768-0.944-2.513-1.561  c-0.912-0.757-0.591-2.365-0.748-3.406c-0.133-0.885-0.257-1.788-0.511-2.647c-0.232-0.782-1.056-1.377-1.83-1.497  c-2.048-0.315-2.91,3.05-3.252,4.491c-0.146,0.617-0.257,1.313-0.743,1.767c-1.239,1.158-2.481-0.202-2.601-1.48  c-0.123-1.303,0.086-2.619-0.003-3.928c-0.055-0.825-0.12-2.17-0.902-2.682c-0.845-0.553-2.265-0.445-2.994,0.269  c-0.851,0.834-1.141,1.916-1.291,3.053c-0.132,0.999-0.215,2.144-1.281,2.606c-0.792,0.343-1.934-0.068-2.372-0.83  c-0.285-0.495-0.321-1.077-0.383-1.631c-0.189-1.692-0.478-3.662-1.56-5.04c-1.063-1.35-2.555-1.142-3.644,0.068  c-1.27,1.413-2.181,3.322-2.952,5.04c-4.992,11.128,2.861,16.207,5.964,16.421c3.102,0.214,14.347-4.3,18.245-3.49  c1.597,0.332,2.679,0.434,3.407,0.441c-0.399,1.963-0.447,3.6-0.464,4.309c0,0-3.426,2.003-5.146,6.089  c-3.75,8.907-1.785,14.099,1.929,18.82c3.715,4.721,15.554,8.065,23.664,6.321c8.11-1.744,11.176-5.396,14.091-13.02  c2.915-7.624-4.918-16.056-4.918-16.056s0.447-3.47-0.569-7.355c0.728-0.001,1.809-0.093,3.406-0.409  c3.905-0.774,15.109,3.845,18.213,3.66C90.155,47.826,98.056,42.82,93.167,31.646z M41.814,59.401  c-0.273,0.416-0.959,1.664-0.856,2.431c0.038,0.286-0.162,0.549-0.448,0.588c-0.024,0.003-0.047,0.005-0.07,0.005  c-0.258,0-0.482-0.191-0.517-0.453c-0.174-1.289,0.896-2.959,1.018-3.145c0.159-0.241,0.483-0.307,0.724-0.149  C41.905,58.836,41.972,59.16,41.814,59.401z M46.386,49.182c-0.938,0-1.699-0.917-1.699-2.047c0-1.131,0.761-2.047,1.699-2.047  s1.699,0.917,1.699,2.047C48.085,48.265,47.325,49.182,46.386,49.182z M55.099,49.182c-0.938,0-1.699-0.917-1.699-2.047  c0-1.131,0.761-2.047,1.699-2.047s1.699,0.917,1.699,2.047C56.798,48.265,56.037,49.182,55.099,49.182z M60.335,62.393  c-0.022,0.003-0.045,0.004-0.068,0.004c-0.259,0-0.483-0.192-0.518-0.455c-0.065-0.494-0.358-1.887-0.937-2.401  c-0.216-0.192-0.236-0.522-0.044-0.738c0.192-0.216,0.522-0.236,0.738-0.044c0.973,0.864,1.25,2.827,1.279,3.049  C60.824,62.094,60.622,62.356,60.335,62.393z">
                    </path>
                </g>
                <g id="SvgjsG5196" featurekey="nameRightFeature-0" transform="matrix(1.6093536173446479,0,0,1.6093536173446479,138.06877558244645,3.730123563142623)" fill="#111111"><path d="M9.72 6 l3.22 0 l0 14 l-3.22 0 l0 -5.54 l-5.3 0 l0 5.54 l-3.22 0 l0 -14 l3.22 0 l0 5.5 l5.3 0 l0 -5.5 z M18.560000000000002 17.04 l5.74 0 l0 2.96 l-6.14 0 l-2.82 0 l0 -14 l3.22 0 l5.56 0 l0 2.96 l-5.56 0 l0 2.54 l4.16 0 l0 2.9 l-4.16 0 l0 2.64 z M34.2 20 l-2.86 -4.58 l-1.72 0 l0 4.58 l-3.22 0 l0 -14 l4.98 0 c3.14 0 5.22 1.9 5.22 4.82 c0 1.86 -0.88 3.26 -2.36 3.98 l3.36 5.2 l-3.4 0 z M29.620000000000005 8.96 l0 3.72 l1.56 0 c1.3 0 2.2 -0.46 2.2 -1.86 c0 -1.38 -0.9 -1.86 -2.2 -1.86 l-1.56 0 z M43.660000000000004 5.76 c2.52 0 4.06 1.56 4.82 2.88 l-2.36 1.42 c-0.78 -1 -1.46 -1.46 -2.46 -1.46 c-0.86 0 -1.5 0.5 -1.5 1.2 c0 0.72 0.4 1.08 1.4 1.42 l0.94 0.34 c3.26 1.14 4.38 2.58 4.38 4.44 c0 2.92 -2.76 4.3 -5.16 4.3 c-2.56 0 -4.52 -1.52 -5.22 -3.46 l2.46 -1.32 c0.5 0.9 1.24 1.88 2.76 1.88 c1.04 0 1.82 -0.42 1.82 -1.36 c0 -0.86 -0.48 -1.26 -1.98 -1.82 l-0.8 -0.28 c-2.06 -0.74 -3.8 -1.72 -3.8 -4.28 c0 -2.28 2.16 -3.9 4.7 -3.9 z"></path>
                </g>
            </svg>
            <!-- <img src="icons/logo.svg" alt="Logo" /> -->
        </div>
        <div class="header__search">
            <button>Selected map area</button>
            <span></span>
            <button>23 Apr - 27 Apr</button>
            <span></span>
            <button>
                1 quest
                <div class="header__searchIcon">
                    <img src="icons/searchIcon.svg" alt="Search Icon" />
                </div>
            </button>
        </div>
        <div class="header__nav">
            <!-- <a href="" class="header__nav__button header__nav__button-greyHover">
                For the reception of guests
            </a> -->
            <% User user = (User) request.getAttribute("user");  %>
            <a href="balance.do" class="var_pink header__nav__button header__nav__button-greyHover">
                Balance replenishment: $<%= user.getBalance() %>
            </a>
            <a href="logout.do" class="header__nav__button header__nav__button-greyHover">
                Log Out
            </a>
            <!-- <button class="header__nav__button header__nav__button-account">
                <img src="icons/hamburger.svg" alt="Hamburger" />
                <img src="icons/account.svg" alt="Account" />
            </button> -->

        </div>
    </header>
    <div class="main">
    	<% Hotel hotel = (Hotel) request.getAttribute("hotel");
    	 %>
        <h1 class="title-of-hotel"><%= hotel.getName() %></h1>
        <div class="feedback">  
            <svg viewBox="0 0 32 32" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" role="presentation" 
                focusable="false" style="display: inline-block; height: 14px; width: 14px; fill: #ff385c;">
                <path d="M15.094 1.579l-4.124 8.885-9.86 1.27a1 1 0 0 0-.542 1.736l7.293 6.565-1.965 9.852a1 
                1 0 0 0 1.483 1.061L16 25.951l8.625 4.997a1 1 0 0 0 1.482-1.06l-1.965-9.853 7.293-6.565a1 1 
                0 0 0-.541-1.735l-9.86-1.271-4.127-8.885a1 1 0 0 0-1.814 0z" fill-rule="evenodd">
                </path>
            </svg>
            <span>4.68</span>
            <span class="element-of-feedback">(372 reviews)</span>
            <span class="element-of-feedback"><%= hotel.getPlace() %></span>
        </div>
        <div class="info-hotel">
            <h2>Luxury Guest Room</h2>
            <span><%= hotel.getNum_of_guests() %> quest · luxury · <%= hotel.getNum_of_bedroom() %> bedroom · 1 bathroom</span>
            <div class="all-info-hotel">
                <div class="element-of-info">
                    <svg viewBox="0 0 32 32" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" 
                        role="presentation" focusable="false" style="display: block; height: 24px; width: 24px; fill: currentcolor;">
                        <path d="M17.954 2.781l.175.164 13.072 12.842-1.402 1.426-1.8-1.768L28 29a2 2 0 0 1-1.85 1.994L26 31H6a2 2 
                        0 0 1-1.995-1.85L4 29V15.446l-1.8 1.767-1.4-1.426L13.856 2.958a3 3 0 0 1 4.097-.177zm-2.586 1.503l-.096.088L6 
                        13.48 6 29l5-.001V19a2 2 0 0 1 1.85-1.995L13 17h6a2 2 0 0 1 1.995 1.85L21 19v9.999h5V13.48l-9.3-9.135a1.001 
                        1.001 0 0 0-1.332-.06zM19 19h-6v9.999h6z">
                        </path>
                    </svg>
                    <div class="text-in-info">
                        <h3 class="title-of-info">Housing in its entirety</h3>
                        <span>The apartment is completely at your disposal.</span>
                    </div>
                </div>
                <div class="element-of-info">
                    <svg viewBox="0 0 32 32" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" role="presentation" 
                        focusable="false" style="display: block; height: 24px; width: 24px; fill: currentcolor;">
                        <path d="M15.032 1.747c.263-1.004 1.692-.993 1.94.015.876 3.577 2.415 6.454 4.614 8.652 
                        2.198 2.199 5.075 3.738 8.652 4.615 1.016.249 1.016 1.693 0 1.942-3.577.877-6.454 2.416-8.652 
                        4.615-2.199 2.198-3.738 5.075-4.615 8.652-.249 1.016-1.693 1.016-1.942 0-.877-3.577-2.416-6.454-4.615-8.652-2.198-2.199-5.075-3.738-8.652-4.615-1.008-.247-1.019-1.676-.015-1.939 3.535-.923 6.394-2.487 8.597-4.69 2.202-2.202 
                        3.765-5.06 4.688-8.595zm.945 3.518l-.133.325c-.88 2.085-2.025 3.914-3.438 5.484l-.33.357-.318.326c-1.6 1.6-3.5 2.893-5.693 3.88l-.475.206-.325.133.352.14c2.108.859 3.952 1.995 5.527 3.407l.358.33.326.319c1.603 
                        1.602 2.887 3.515 3.854 5.732l.203.48.115.291.115-.292c.86-2.108 1.996-3.952 3.408-5.527l.33-.358.319-.326c1.602-1.603 3.515-2.887 
                        5.732-3.854l.48-.203.292-.115-.293-.115c-2.421-.988-4.494-2.34-6.211-4.057-1.603-1.602-2.887-3.515-3.854-5.732l-.203-.48-.138-.351zm11.04-3.891c.13-.502.845-.497.969.007.176.718.48 1.287.913 
                        1.72.433.433 1.002.737 1.72.913.508.125.508.847 0 .972-.718.176-1.287.48-1.72.913-.433.433-.737 1.002-.913 1.72-.125.508-.847.508-.972 0-.176-.718-.48-1.287-.913-1.72-.433-.433-1.002-.737-1.72-.913-.504-.124-.51-.839-.007-.97.71-.185 1.277-.496 
                        1.712-.93.434-.435.745-1.002.93-1.712z"></path>
                    </svg>
                    <div class="text-in-info">
                        <h3 class="title-of-info">Extended cleaning service</h3>
                        <span>The hotel follows an extended cleaning protocol.</span>
                    </div>
                </div>
                <div class="element-of-info">
                    <svg viewBox="0 0 32 32" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" role="presentation" focusable="false" 
                        style="display: block; height: 24px; width: 24px; fill: currentcolor;">
                        <path d="M12 1c6.075 0 11 4.925 11 11 0 1.464-.287 2.888-.834 4.208l-.166.378 9 
                        9V31h-5.414l-4.001-4H16v-4.753l-.155.062a10.95 10.95 0 0 1-3.001.66l-.446.024L12 
                        23C5.925 23 1 18.075 1 12S5.925 1 12 1zm0 2a9 9 0 1 0 0 18c1.409 0 2.77-.323 4-.935l.305-.16.658-.358L18 20.587V25h4.414l4.001 
                        4H29v-2.585l-9.453-9.453.359-.657A8.954 8.954 0 0 0 21 12a9 9 0 0 0-9-9zM9 6a3 3 0 1 1 0 
                        6 3 3 0 0 1 0-6zm0 2a1 1 0 1 0 0 2 1 1 0 0 0 0-2z"></path>
                    </svg>
                    <div class="text-in-info">
                        <h3 class="title-of-info">Arrival is organized perfectly</h3>
                        <span>90% of recent guests rated the arrival five stars.</span>
                    </div>
                </div>
                <div class="element-of-info">
                    <svg viewBox="0 0 32 32" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" role="presentation" 
                        focusable="false" style="display: block; height: 24px; width: 24px; fill: currentcolor;">
                        <path d="M12 0v2h8V0h2v2h6a2 2 0 0 1 1.995 1.85L30 4v15.586a2 2 0 0 1-.467 
                        1.284l-.119.13L21 29.414a2 2 0 0 1-1.238.578l-.176.008H7a5 5 0 0 1-4.995-4.783L2 25V4a2 
                        2 0 0 1 1.85-1.995L4 2h6V0zM4 12v13a3 3 0 0 0 2.824 2.995L7 28h11v-5a5 5 0 0 1 
                        4.783-4.995L23 18h5v-6zm23.585 8H23a3 3 0 0 0-2.995 2.824L20 23v4.585zM4 
                        10h24V4h-6v2h-2V4h-8v2h-2V4H4z"></path>
                    </svg>
                    <div class="text-in-info">
                        <h3 class="title-of-info">Cancellation Policy</h3>
                        <span id="except">If you cancel before 4: 00 PM on 27 Apr, you will receive a 50% refund minus the service fee.</span>
                    </div>
                </div>
            </div>
        </div>
        <div class="booking-container">
            <div class="form-head">
                <div class="form-head-left">
                    <h2 class="old-price"><%= hotel.getPrice_for_night() %></h2>
                    <h2 class="new-price"> <%= hotel.getPrice_for_night()*0.8 %></h2>
                    <span>night</span>
                </div>
                <div class="form-head-right">
                    <svg viewBox="0 0 32 32" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" role="presentation" 
                        focusable="false" style="display: inline-block; height: 14px; width: 14px; fill: #ff385c;">
                        <path d="M15.094 1.579l-4.124 8.885-9.86 1.27a1 1 0 0 0-.542 1.736l7.293 6.565-1.965 9.852a1 
                        1 0 0 0 1.483 1.061L16 25.951l8.625 4.997a1 1 0 0 0 1.482-1.06l-1.965-9.853 7.293-6.565a1 1 
                        0 0 0-.541-1.735l-9.86-1.271-4.127-8.885a1 1 0 0 0-1.814 0z" fill-rule="evenodd">
                        </path>
                    </svg>
                    <span id="element"><%= hotel.getGrade() %></span>
                    <span class="element-of-right-form">(<%= hotel.getNum_of_grades() %> reviews)</span>
                </div>
            </div>
            <form action="hotel.do" class="booking" method="POST">
                <div class="form-in">
                    <div class="form-inner">
                        <div class="labels">
                            <label for="firstDay" class="form-label">ARRIVAL</label>
                            <input type="text" name="firstDay" class="form-input" placeholder="04.05.2021" readonly>
                        </div>
                        <div class="labels lb">
                            <label for="lastDay" class="form-label">EXIT</label>
                            <input type="text" class="form-input" name="lastDay" placeholder="22.05.2021" readonly>
                        </div>
                    </div>
                    <div class="labels2">
                        <label for="guest" class="form-label2">GUESTS</label>
                        <input type="text" class="form-input2" name="guest" placeholder="1 guest">
                    </div>
                </div>
                <input type="submit" value="To book" class="sbt" name="action">
            </form>
            <span id="under-form">As long as you don't pay for anything</span>
            <div class="cash">
                <span><%= hotel.getPrice_for_night()*0.8 %> x 18 nights</span>
                <span><%= hotel.getPrice_for_night()*0.8 * 18 %></span>
            </div>
            <div class="cash">
                <span class="underline">12% discount (per week)</span>
                <span class="green"><%= (int) ( hotel.getPrice_for_night()*0.8 * 18 * 0.12 ) %></span>
            </div>
            <hr/>
            <div class="cash">
                <span class="total">Total</span>
                <span class="total"><%= hotel.getPrice_for_night()*0.8 * 18 - (int) (hotel.getPrice_for_night()*0.8 * 18 * 0.12) %></span>
            </div>
        </div>
    </div>
    <footer>
        <div class="container">
            <div>
                <h4>О нас</h4>
                <ul>
                    <li>How 4 BROTHERS works</li>
                    <li>News Department</li>
                    <li>4BROTHERS Plus</li>
                    <li>4BROTHERS Luxe</li>
                    <li>HotelTonight</li>
                </ul>
            </div>
        </div>
        <div class="footer-inner">
            <div class="footer-left-side">
                © 2021 4BROTHERS, Inc.
                <a href="#" class="footer-nav">· Privacy policy</a>
                <a href="#" class="footer-nav">·Terms and Conditions</a>
            </div>

            <div class="footer-right-side">
                <a href="#" class="footer-nav"><i class="fab fa-facebook-f fa-lg"></i></a>
                <a href="#" class="footer-nav"><i class="fab fa-vk fa-lg"></i></a>
                <a href="#" class="footer-nav"><i class="fab fa-twitter fa-lg"></i></a>
                <a href="#" class="footer-nav"><i class="fab fa-instagram fa-lg"></i></a>
            </div>
        </div>
    </footer>
</body>
</html>