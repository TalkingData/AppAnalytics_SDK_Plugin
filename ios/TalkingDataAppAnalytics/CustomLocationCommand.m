//
//  CustomLocationCommand.m
//  SDKAutoInsertPlugin
//
//  Created by Robin on 2018/10/14.
//  Copyright © 2018 TendCloud. All rights reserved.
//

#import "CustomLocationCommand.h"

@implementation CustomLocationCommand

- (void)performCommandWithInvocation:(XCSourceEditorCommandInvocation *)invocation completionHandler:(void (^)(NSError * _Nullable nilOrError))completionHandler
{
    // Implement your command here, invoking the completion handler when done. Pass it nil on success, and an NSError on failure.
    
    NSString *custom_location_str = @"\t[TalkingData setLatitude:<#纬度#> longitude:<#经度#>];";
    
    [self insertEditableWithInvocation:invocation contents:custom_location_str editPosition:custom_location_str.length + 1];
    
    completionHandler(nil);
}

@end
