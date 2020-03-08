// Doumento JavaScript
// Añadir una clase al nivel superior de los items de la lista.
$(document).ready(function() {
  $('#obras-seleccionadas > li').addClass('horizontal');
  $('#obras-seleccionadas li:not(.horizontal)').addClass('sub-level');
});

// Add a class to all mailto and pdf links on the page.
$(document).ready(function() {
  $('a[@href^="mailto:"]').addClass('mailto');
  $('a[@href$=".pdf"]').addClass('pdflink');
  $('a[@href*="mysite.com"]').addClass('mysite');
});

