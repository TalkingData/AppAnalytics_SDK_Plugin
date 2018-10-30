//
//  WatchOSPageTrackEndCommand.m
//  SDKAutoInsertPlugin
//
//  Created by Robin on 2018/10/16.
//  Copyright © 2018 TendCloud. All rights reserved.
//

#import "WatchOSPageTrackEndCommand.h"

@implementation WatchOSPageTrackEndCommand

- (void)performCommandWithInvocation:(XCSourceEditorCommandInvocation *)invocation completionHandler:(void (^)(NSError * _Nullable nilOrError))completionHandler
{
    // Implement your command here, invoking the completion handler when done. Pass it nil on success, and an NSError on failure.
    
    NSString *track_end_str = @"\t[TalkingData trackPageEnd:<#页面名称#>];";
    
    [self insertEditableWithInvocation:invocation contents:track_end_str editPosition:track_end_str.length + 1];
    
    completionHandler(nil);
}

@end
