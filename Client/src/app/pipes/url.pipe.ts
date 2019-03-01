import { Pipe, PipeTransform } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';

@Pipe({
  name: 'pieURL'
})
export class UrlPipe implements PipeTransform {
  
  constructor(private cleaner: DomSanitizer) { }
  transform(url?) {
    return this.cleaner.bypassSecurityTrustResourceUrl(url);
  }


}
