(function() {
    "use strict";

    document.addEventListener("DOMContentLoaded", function() {
        var teamContainers = document.querySelectorAll('[data-cmp-is="team-members"]');
        teamContainers.forEach(function(container) {
            var cards = container.querySelectorAll('.team-member-card');
            cards.forEach(function(card) {
                card.addEventListener('click', function() {
                    // Toggle active state on card click
                    card.classList.toggle('is-active');
                    var name = card.querySelector('.team-member-card__name');
                    if (name) {
                        console.log('Selected team member:', name.textContent.trim());
                    }
                });
            });
        });
    });
})();
