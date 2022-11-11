document.querySelector("#profiledrop button").addEventListener("click", (e) => {
    if (document.querySelector("#profiledrop .menudrop").dataset.expanded === "false") {
        document.querySelector("#profiledrop .menudrop").classList.add("transition", "ease-out", "duration-100");
        document.querySelector("#profiledrop .menudrop").classList.add("transform", "opacity-100", "scale-100");
        document.querySelector("#profiledrop .menudrop").classList.remove("transform", "opacity-0", "scale-95", "hidden");
        document.querySelector("#profiledrop .menudrop").dataset.expanded = "true";

        setTimeout(() => {
            document.querySelector("#profiledrop .menudrop").classList.remove("transition", "ease-out", "duration-100");
        }, 101);
    } else {
        document.querySelector("#profiledrop .menudrop").classList.add("transition", "ease-in", "duration-75");
        document.querySelector("#profiledrop .menudrop").classList.add("transform", "opacity-0", "scale-95");
        document.querySelector("#profiledrop .menudrop").classList.remove("transform", "opacity-100", "scale-100");
        document.querySelector("#profiledrop .menudrop").dataset.expanded = "false";

        setTimeout(() => {
            document.querySelector("#profiledrop .menudrop").classList.add("hidden");
            document.querySelector("#profiledrop .menudrop").classList.remove("transition", "ease-out", "duration-100");
        }, 101);
    }
});

document.querySelector("#profiledrop button").addEventListener("blur", (e) => {
    if (document.querySelector("#profiledrop .menudrop").dataset.expanded === "true") {
        document.querySelector("#profiledrop .menudrop").classList.add("transition", "ease-in", "duration-75");
        document.querySelector("#profiledrop .menudrop").classList.add("transform", "opacity-0", "scale-95");
        document.querySelector("#profiledrop .menudrop").classList.remove("transform", "opacity-100", "scale-100");
        document.querySelector("#profiledrop .menudrop").dataset.expanded = "false";

        setTimeout(() => {
            document.querySelector("#profiledrop .menudrop").classList.add("hidden");
            document.querySelector("#profiledrop .menudrop").classList.remove("transition", "ease-out", "duration-100");
        }, 101);
    }
});