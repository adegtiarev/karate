/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Project: https://karatelabs.github.io/karate
*    Release: https://github.com/karatelabs/karate/releases/tag/v1.2.0.RC1
*    Source File: karate-report.js
*    
*    Copyrights:
*      copyright 2017 intuit inc
*    
*    Licenses:
*      MIT License
*      SPDXId: MIT
*    
*    Auto-attribution by Threatrix, Inc.
*    
*    ------ END LICENSE ATTRIBUTION ------
*/
window.onload = function () {
  $('div.step-container').each(function (i) {
    var id = this.id;
    var children = $("[data-parent='" + id + "']");
    if (children.length > 0) {
      children.hide('fast');
      $(this).wrap("<a href='javascript:void(0)'></a>").click(function () {
        children.toggle('fast');
      });
    }
  });
  $("table.features-table").tablesorter();
  $("table.tags-table").tablesorter();
}
